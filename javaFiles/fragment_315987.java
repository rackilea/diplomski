if (Build.VERSION.SDK_INT >= 21) {
                    TransitionInflater inflater = TransitionInflater.from(LoginActivity.this);
                    Transition transition = inflater.inflateTransition(R.transition.fade_transition);
                    TransisitonTime = transition.getDuration()*2;
                    getWindow().setExitTransition(transition);
                }

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);