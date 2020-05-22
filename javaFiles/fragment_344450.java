import javax.validation.constraints.Size;

        class User {

            @Size(max = 10)
            String name;

            public String getName() {
            return name;
            }

            public void setName(String name) {
            this.name = name;
            }

        }