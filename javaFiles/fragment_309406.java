@Override
public List<SearchedFolder> getSearchedFolder(Long folderId) {
    Criteria ctria = schedulerSessionFactory.getCurrentSession().createCriteria(SearchedFolder.class)
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
            .setFetchMode("childFiles", FetchMode.SELECT);
    List<SearchedFolder> folders = (List<SearchedFolder>) ctria.list();
    ctria.add(Restrictions.eq("folderId", folderId));
    return folders;
}