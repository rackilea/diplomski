Integer count = voteDao.countBySiteUser(user);

if (count == null) {
    count = 0;
}

System.out.println("!!!!: PROPOSAL VoteService: " + count);