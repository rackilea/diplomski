let test = {
  "application": "ERP",
  "subject": "Quote 0000005 from TestSG",
  "exportDocumentRequest": {
    "documentDate": "05-02-2020",
    "tenantBillingAddr": null,
    "code": "0000"
  }
}

let updated_test = {
  ...test,
  "exportDocumentRequest": {
    ...test.exportDocumentRequest,
    "code": "5000"
  }
}

console.log(updated_test)