add(new AbstractAjaxTimerBehavior(Duration.seconds(1))
        {
            @Override
            protected void onTimer(AjaxRequestTarget target)
            {
                target.add(label);
            }
        });