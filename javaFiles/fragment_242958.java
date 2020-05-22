class HistoryServiceImpl implements CaseHistory {
    MemberUtil memberUtil = new MemberUtil();

    @Override
    public List<CaseHistoryDto> getCaseHistory(Individual member, Individual provider) {
        ...
    }
}