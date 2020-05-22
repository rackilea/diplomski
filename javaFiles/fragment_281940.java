rule "IBAN doesn't begin with a country ISO code."
    no-loop
when
    $req: IbanValidationRequest($iban:iban, $country:iban.substring(0, 2))
    not Country(isoCode == $country) from countryList
then
    $req.reject("The IBAN does not begin with a 2-character country code. '" + $country + "' is not a country.");
    update($req);
end