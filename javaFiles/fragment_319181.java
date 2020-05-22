if (i == ITEM_TYPE_ASSIGNED_TASK) {
        View view = layoutInflater.inflate(R.layout.layout_curent_user_assigned_tasks_item, viewGroup, false);

        return new AssignedTaskViewHolder(view);
    } else if (i == ITEM_TYPE_PUBLISHED_TASK) {
        View view = layoutInflater.inflate(R.layout.layout_current_user_pending_tasks, viewGroup, false);

        return new PublishedTaskViewHolder(view);
    }