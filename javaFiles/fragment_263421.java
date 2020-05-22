final Intent emailIntent = new Intent(
                    android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                    new String[] { vendoremail });
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                    _productList.get(0).ProductName);

            startActivity(Intent.createChooser(emailIntent, "Send mail..."));