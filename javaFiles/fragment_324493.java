import java.util.List;

public class Info {

    private String entry;
    private Product product;

    public class Product {

        private String item;
        private List<Prompt> prompts;

        public class Prompt {

            private String promptId;
            private String promptNumber;
            private int promptType;
            private String promptTypeDes;
            private List<Validation> validations;

            public class Validation {

                private int maxLen;
                private int minLen;
                private boolean required;
            }
        }
    }
}