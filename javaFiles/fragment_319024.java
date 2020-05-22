databaseObjectsList.sort(
        Comparator.comparing(DatabaseObject::getGroupId)
                .thenComparing(DatabaseObject::getArtifactId)
                .thenComparing(DatabaseObject::getVersion)
);
apiObjects.sort(Comparator.comparing(APIObject::getGroupId)
        .thenComparing(APIObject::getArtifactId)
        .thenComparing(APIObject::getVersion)
);

return databaseObjectsList.equals(apiObjects);