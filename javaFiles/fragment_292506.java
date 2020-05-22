//!! boolean featuredCheck = featuredCB.isSelected(); // ***** get rid of this variable

submitBT.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == submitBT)
        {   
            idContent.setUser(userTF.getText());
            idContent.setMovie(titleTF.getText());

            //  !!!   idContent.setFeatured(featuredCheck);  // **** no *****
            idContent.setFeatured(featuredCB.isSelected(););  // *****yes ****

            idContent.setRating(Integer.parseInt(ratingTF.getText()));
            if(owner.updateReview(isUpdate, idContent))
            {
                // success
                try {
                    MovieReviewDSC.add(idContent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else
            {
                // fail
            }
        }
    }