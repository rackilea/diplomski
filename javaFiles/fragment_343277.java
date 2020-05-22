mButton.setOnClickListener(
            new View.OnClickListener()
            {
                public void onClick(View view)
                {
                     userInput11 = mEdit.getText().toString();
                }
            });

    service.refreshWeather(userInput11);