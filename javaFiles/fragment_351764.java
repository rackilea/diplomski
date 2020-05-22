sort(List<SortCriterion> sortCriteria, List<T> list){
    Collections.sort(list, new Comparator<T>()
            {
            public int compare(T one, T two)
                {
            CompareToBuilder compToBuild = new CompareToBuilder();
            sortCriteria.stream().forEachOrdered(sc->{
                String fieldName = sc.getField();
                String direction = sc.getDirection();
                String fv1 = getFieldValue(fieldName, one);
                String fv2 = getFieldValue(fieldName, two);
                if(direction.equals("ASC")){            
                    compToBuild.append(fv1,fv2);                
                }
                if(direction.equals("DESC")){               
                    compToBuild.append(fv2,fv1);

                }
            });
            return compToBuild.toComparison();

                }

            });
}