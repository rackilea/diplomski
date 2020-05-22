missionProperty().addListener((ov, m, m1) -> {
            if (m1 != null) {
                executeButtonDisabled.bind(m1.statusProperty().isNotEqualTo(Mission.Status.CREATED));
            }else {
                executeButtonDisabled.unbind();
                executeButtonDisabled.set(false);
            }
        });