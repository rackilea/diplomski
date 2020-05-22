model1List.forEach(model1 -> 
    model1.getModel2List().forEach(model2 ->
        model2.getModel3List().forEach(model3 -> 
            model3.getModel4List().removeIf(model4 -> model4.getModelName().equals("ABC"))
        )
    )
);