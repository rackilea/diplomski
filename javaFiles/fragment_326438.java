gemScore.registerEntityModifier(new AlphaModifier(2f, 1f, 0f, new IEntityModifierListener() {

        @Override
        public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
            // TODO Auto-generated method stub
            runOnUpdateThread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    board.detachChild(gemScore);
                }
            });
        }
    }));