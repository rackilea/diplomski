String where = "";
if (eBy != null && eBy != EBy.All) {
    where += ((where == "") ? " WHERE " : " AND ") + " SEARCH_BY = '" + eBy.name() + "'";
}
if (eStatus != null && eStatus != EStatus.All) {
    where += ((where == "") ? " WHERE " : " AND ") + " SEARCH_STATUS = '" + eStatus.name() + "'";
}
if (ePrivacy != null && ePrivacy != EPrivacy.All) {
    where += ((where == "") ? " WHERE " : " AND ") + " SEARCH_PRIVACY = '" + ePrivacy.name() + "'";
}
searchQuery += where;