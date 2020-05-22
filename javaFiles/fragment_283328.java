private void executeProgramApiCall(int programId) {
    ApiClient.getApiClient(this).getProgram(programId, new RetrofitCallback<Program>() {

        @Override
        public void success(Program program, Response response) {
            super.success(program, response);
            addDataToAdapter(program);
        }
    });
}