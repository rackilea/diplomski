//instead of a count, you could also use a boolean
for (int i = 0, count= 0; i < orderID.length; i++) {
                if (idInputString.equals(startDate[i])) {

                    txtOrderID.setText(orderID[i]);
                    txtOrderForename.setText(customerForename[i]);
                    txtOrderSurname.setText(customerSurname[i]);

                    txtOrderAddress1.setText(address1[i]);
                    txtOrderAddress2.setText(address2[i]);
                    txtOrderTown.setText(town[i]);
                    txtOrderCounty.setText(county[i]);
                    txtOrderPost.setText(postCode[i]);
                    txtOrderCarModel.setText(carModel[i]);

                    txtOrderCarReg.setText(carReg[i]);
                    txtOrderStartDate.setText(startDate[i]);
                    txtOrderStartTime.setText(startTime[i]);

                    txtOrderSerial.setText(serialNum[i]);
                    count++;
                } 
                if(i == orderID.length - 1 && count==0){
                    JOptionPane.showMessageDialog(null, "Order ID Doesn't Exist", "Error!", JOptionPane.WARNING_MESSAGE);
                    break;
                }

            }