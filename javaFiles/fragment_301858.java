for (Object o : query.getResultList()) {
    Object[] cols = (Object[]) o;
    Garbage tmpG = new Garbage();
    tmpG.setFilename(cols[0]);
    tmpG.setDescription(cols[1]);
    tmpG.setUploadDate(cols[2]);

    gList.add(tmpG);
}