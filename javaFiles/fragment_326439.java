mainScene.registerEntityModifier(new DelayModifier(3, new IEntityModifierListener() {

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
                    mainScene.detachChild(sign);
                }
            });
        }
    }));