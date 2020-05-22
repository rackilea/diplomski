// Create a new knowledge session from an existing knowledge base
StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
// Create a validation request
PaymentValidationRequest request = new PaymentValidationRequest(payment);
// A stateless session is executed with a collection of Objects, so we
// create that collection containing just our request. 
List<Object> facts = new ArrayList<Object>();
facts.add(request);

// And execute the session with that request
ksession.execute(facts);

// At this point, rules such as that above should have been activated.
// The rules modify the original request fact, setting a flag to indicate 
// whether it is valid and adding annotations to indicate if/why not.
// They may have added annotations to the request, which we can now read.

FxPaymentValidationResult result = new FxPaymentValidationResult();
// Get the annotations that were added to the request by the rules.
result.addAnnotations(request.getAnnotations());

return result;