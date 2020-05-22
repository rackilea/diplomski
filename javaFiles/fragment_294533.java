while (!comparatorStack.empty()) {

    SearchOperationRequest searchOperationRequest = comparatorStack.pop();

    Specification<U> operand1 = specStack.pop();
    Specification<U> operand2 = specStack.pop();
    if (searchOperationRequest.getComparator().equals(SearchComparator.AND)) {
        specStack.push(Specification.where(operand1)
                .and(operand2));
    } else if (searchOperationRequest.getComparator().equals(SearchComparator.OR)) {
        specStack.push(Specification.where(operand1)
                .or(operand2));
    }
}