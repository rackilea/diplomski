@Override
            public void afterTextChanged(Editable textVal) {
                // takes out all non-digits from string
                String inputNo = textVal.toString().replaceAll("[^\\d]","");
                if (inputNo.length() == 10) {
                    tv.setText(inputNo);
                }

            }