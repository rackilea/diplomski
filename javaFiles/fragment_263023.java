public function TestForPost(Request $request) {
    //Verify if the $request is a json
    $input = $request->json()->all(); //read json in request
    if (!empty($input)) {
    ...
}