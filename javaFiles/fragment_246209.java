class SaltPOJO {
        @SerializedName("CODE")
        private String code = null;
        @SerializedName("USER")
        private User user = null;
        ...

        class User {
            @SerializedName("E_MAIL")
            private String e_mail = null;
            @SerializedName("SALT")
            private String salt = null;