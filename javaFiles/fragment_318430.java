ImageCaptchaService instance = new DefaultManageableImageCaptchaService(
            new FastHashMapCaptchaStore(),
            new MyImageCaptchaEngine(),
            180,
            100000,
            75000);