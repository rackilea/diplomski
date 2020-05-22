BinaryOperator<Product> merge = (p1, p2) -> {
       if (p1.getVersion() != null && p2.getVersion() != null) {
            if (p1.getVersion().getState().equals("Actif")) return p1;
            else if (p2.getVersion().getState().equals("Actif")) return p2;
        } else {
            return p1.getCreatedDate().isAfter(p2.getCreatedDate()) ? p1 : p2;
        }
        return null;
    };

listOfProduct.stream()
                .collect(Collectors.toMap(Product::getName, Function.identity(), merge))
                .values();