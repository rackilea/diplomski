setRetrofitCall(new Function1<String, Unit>() {
        @Override
        public Unit invoke(String s) {
            LoginService.getLoginData(s); //I'm pretty sure LoginService is supposed to be static?
            return Unit.INSTANCE;
        }
    }
);