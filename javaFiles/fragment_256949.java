newTask = asanaClient.tasks.createInWorkspace(workspaceId)
                        .data("name", "MyProofTask")
                        .data("notes", "MyDescriptionTask")
                        .data("projects", Arrays.asList(newProject.id))
                        .data("due_at", (copyTask.dueAt != null) ? new com.google.api.client.util.DateTime (copyTask.dueAt.getValue()) : null)
                        .data("due_on", (copyTask.dueOn != null ? new com.google.api.client.util.DateTime (copyTask.dueOn.getValue()) : null))
                        .execute();