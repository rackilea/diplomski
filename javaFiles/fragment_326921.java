final boolean isStayAwake = isStayAwakeEnabled(context);

if (!isStayAwake) {
    intent = new Intent(ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
}

context.startActivity(intent);