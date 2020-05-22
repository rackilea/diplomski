ArrayList<Main>listMain = mainDAO.getlAllMain(Connection con);
    Map<Integer, Pair<A, B>> map = new Hashmap<>();

    for (int i = 0; i < listMain.size(); i++) {
       ArrayList<A> listA = aDAO.getallbyMainId(Connection con, int main);
       ArrayList<B> listB = bDAO.getallbyMainId(Connection con, int main);
       A aValue = listA.get(i);
       B bValue = listB.get(i);
       map.put(i, new Pair(aValue, bValue));
    }