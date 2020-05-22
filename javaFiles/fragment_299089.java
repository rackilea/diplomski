val typeItems = TypeItems(
                product.getString("car_type"),
                product.getString("type"),
                product.getString("model"),
                url2
        )
        if(!list.contains(typeItems)) {
            list.add(typeItems)
        }