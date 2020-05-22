@Override
            public void afterTextChanged(Editable textVal) {
                String inputNo = textVal.toString();
                if (inputNo.length() == 10) {
                    tv.setText(inputNo);
                }

            }