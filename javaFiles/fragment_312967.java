Collection<RefModel> refModels = selectDistinct(flatten(convert(models, (Converter<Model, List<RefModel>>)(m)->{
            List<RefModel> refs = new ArrayList<RefModel>();
            for(String a:m.getPropertyA()){
                for(String b:m.getPropertyB()){
                    for(String c:m.getPropertyC()){
                        refs.add(new RefModel(a, b, c, m));
                    }
                }
            }
            return refs;
        })));