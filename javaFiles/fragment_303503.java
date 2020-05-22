public static class Security extends Controller {

        /**
         * @Deprecated
         *
         * @param username
         * @param password
         * @return
         */
        static boolean authentify(String username, String password) {
            throw new UnsupportedOperationException();
        }

        /**
         * This method is called during the authentication process. This is
         * where you check if the user is allowed to log in into the system.
         * This is the actual authentication process against a third party
         * system (most of the time a DB).
         *
         * @param username
         * @param password
         * @return true if the authentication process succeeded
         */
        static boolean authenticate(String username, String password) {
            return true;
        }

        /**
         * This method checks that a profile is allowed to view this
         * page/method. This method is called prior to the method's controller
         * annotated with the @Check method.
         *
         * @param profile
         * @return true if you are allowed to execute this controller method.
         */
        static boolean check(String profile) {
            return true;
        }

        /**
         * This method returns the current connected username
         *
         * @return
         */
        static String connected() {
            return session.get("username");
        }

        /**
         * Indicate if a user is currently connected
         *
         * @return true if the user is connected
         */
        static boolean isConnected() {
            return session.contains("username");
        }

        /**
         * This method is called after a successful authentication. You need to
         * override this method if you with to perform specific actions (eg.
         * Record the time the user signed in)
         */
        static void onAuthenticated() {

            UserGcv user = UserGcv.find("byLogin", connected()).first();

            Cache.set("user_" + session.get("username"), user, "60min");

            switch (user.profil) {
                case ADMIN:
                    Administration.showUsers();
                    break;
                case DMC:
                    Catalogs.consultArticle();
                    break;
                case DCGP:
                    DCGPArticle.consultArticleDCGP();
                    break;
                case DCE:
                    DCEArticle.consultArticleDCE();
                    break;
                case Planificateur:
                    Planificateur.composerVersion();
                    break;
                case PARAMETRAGE:
                    PARAMETRAGE.createParam();
                    break;
                case ConfAvantage:
                    ConfigAvantage.homeConfigurateur();
                    break;
                case ValidAvantage:
                    ValidateurAvantage.homeValidateur();
                    break;
                case PlanifDSC:
                    PlanifDSC.homePlanifDSC();
                    break;
            }
        }