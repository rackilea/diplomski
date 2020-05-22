public void Previous()
            {
                    if (index > 0)
                    {
                            index--;
                    }
                    txtName.setText(Name.get(index));
                    txtPhone.setText(Phone.get(index));
                    txtMobile.setText(Mobile.get(index));
                    txtAddress.setText(Address.get(index));

            }

  public void Next()
            {
                    if(index < temp.size() - 1){
                       index++;
                     }
                    txtName.setText(Name.get(index));
                    txtPhone.setText(Phone.get(index));
                    txtMobile.setText(Mobile.get(index));
                    txtAddress.setText(Address.get(index));

            }