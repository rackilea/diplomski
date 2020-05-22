fragmentManager.beginTransaction()
        .replace(R.id.container, SuikodenFragment.newInstance(position + 1))
        .replace(R.id.container, SuikodenIIFragment.newInstance(position + 1))
        .replace(R.id.container, SuikodenIIIFragment.newInstance(position + 1))
        .replace(R.id.container, SuikodenIVFragment.newInstance(position + 1))
        .replace(R.id.container, SuikodenVFragment.newInstance(position + 1))
        .commit();