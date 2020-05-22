@metadata_key( metadata_value1, metadata_value2, ...  )

rule "Driving Licence: Age >= 18"
@LegalRequirement("Section 103 RTA 1988")
when
    $applicant: Applicant(age < 18)
    $application: Application()
then 
    $application.setValid(false);
end