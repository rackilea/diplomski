config = cmd_ln_init(NULL, ps_args(), "-inmic", "yes", TRUE, NULL);

    if (config == NULL || cmd_ln_boolean_r(config, "-inmic") == FALSE) {
        E_INFO("Specify '-inmic yes' to recognize from microphone.\n");
        cmd_ln_free_r(config);

    }