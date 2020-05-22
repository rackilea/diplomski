enum Operation{ADD, SUBTRACT;

        public int evaluate(int operand1, int operand2) throws IllegalOperationException {
            switch(this) {
            case ADD: return operand1 + operand2;
            case SUBTRACT: return operand1 - operand2;
            default:
                break;
            }
            throw new IllegalOperationException();
        }

        public static Operation getOperator(String operator) throws IllegalOperationException{
            for(Operation o: Operation.values()){
                if(o.toString().equals(operator)){
                    return o;
                }
            }
            throw new IllegalOperationException();
        }
    };