@Override
        public byte[] getBody() throws AuthFailureError {
            try {                    
                return stringRequestBody.getBytes("utf-8"); //String Request Body with Encoded
            } catch (UnsupportedEncodingException uee) {
                return null;
            }
        }