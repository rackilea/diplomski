public class Size {
    private final int id;
    private final String value;
    private final String info;

    public Size(int id, String value, String info) {
        this.id = id;
        this.value = value;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getInfo() {
        return info;
    }

    public static class Builder {
        private int id;
        private String value;
        private String info;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        @JsonIgnore
        public Builder setInfo(String info) {
            this.info = info;
            return this;
        }

        public Size build() {
            return new Size(id, value, info);
        }
    }
}

public class Product {
    private final int id;
    private final String name;
    private final Size[] sizes;
    private final boolean organic;

    public Product(int id, String name, Size[] sizes, boolean organic) {
        this.id = id;
        this.name = name;
        this.sizes = sizes;
        this.organic = organic;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Size[] getSizes() {
        return sizes;
    }

    public boolean isOrganic() {
        return organic;
    }

    public static class Builder {
        private int id;
        private String name;
        private List<Size.Builder> sizeBuilders;
        private boolean organic;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSizeBuilders(List<Size.Builder> sizeBuilders) {
            this.sizeBuilders = sizeBuilders;
            return this;
        }

        public Builder setOrganic(boolean organic) {
            this.organic = organic;
            return this;
        }

        public Product build() {
            if (organic) {
                for (Size.Builder sizeBuilder : sizeBuilders) {
                    sizeBuilder.setInfo("Organic");
                }
            }
            Size[] sizes = new Size[sizeBuilders.size()];
            for (int i = 0; i < sizeBuilders.size(); i++) {
                sizes[i] = sizeBuilders.get(i).build();
            }
            return new Product(id, name, sizes, organic);
        }
    }
}