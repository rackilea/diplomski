public class ProductInventory {

        private Integer id;
        private String name;
        private List<Variant> variants = null;

        public Integer getId() {
        return id;
        }

        public void setId(Integer id) {
        this.id = id;
        }

        public String getName() {
        return name;
        }

        public void setName(String name) {
        this.name = name;
        }

        public List<Variant> getVariants() {
        return variants;
        }

        public void setVariants(List<Variant> variants) {
        this.variants = variants;
        }
        }

    //class Variant
        public class Variant {

        private String size;
        private Double price;
        private Integer taxCode;

        public String getSize() {
        return size;
        }

        public void setSize(String size) {
        this.size = size;
        }

        public Double getPrice() {
        return price;
        }

        public void setPrice(Double price) {
        this.price = price;
        }

        public Integer getTaxCode() {
        return taxCode;
        }

        public void setTaxCode(Integer taxCode) {
        this.taxCode = taxCode;
        }           
        }