if (n.getCategorie().getNum() == Categorie.INTERNATIONAL.getNum()) {
  updateList(jListInternationales);
} else if (n.getCategorie().getNum() == Categorie.POLITIQUE.getNum()) {
  updateList(jListViePolitique);
} // etc

NewsInter.put(""+nNews, n);