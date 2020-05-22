84     public String getErrorSignifierAsString() {
85         if ("".equals(this.getExceptionType())) {
86            if (getErrorCode() == -1) {
87                return null;
88            } else {
89                return String.valueOf(this.getErrorCode());
90            }
91         }
92         return this.getExceptionType();
93     }