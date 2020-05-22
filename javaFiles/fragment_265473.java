public void TestAddPassengerAndConfirm()
{
    Page uncertainPage = new LoginPage(driver).Login("username", "password")
                                              .NavigateToSearch()
                                              .Search( /* input search criteria */ )
                                              .SelectSearchResult(Result.First);
    if (uncertainPage is PassengerPage)
    {
        PassengerPage passengerPage = (PassengerPage) uncertainPage;
        uncertainPage = passengerpage.AddPassenger(new Passenger()
                                                       {
                                                           FirstName = "first",
                                                           LastName = "last",
                                                       })
                                     .AddPassenger(new Passenger()
                                                       { 
                                                           // More properties
                                                       });
     }
    if (uncertainPage is ConfirmationPage)
    {
        ConfirmationPage confirmationPage = (ConfirmationPage) uncertainPage;
        confirmationPage.ConfirmPassengers();
    }
}