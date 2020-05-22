for (int i = 0; i < list.size(); i++) {
    IssueDBDTO issueDisplayDTO = new IssueDBDTO(); // Here.
    issueDisplayDTO.setIssueNumber(list.get(i).getId());
    // ...
    modifiedList.add(issueDisplayDTO);
}