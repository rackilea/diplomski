task assembleForTest(type: Sync, dependsOn: build) {
    /* configuration phase, evaluated always and before execution phase of any task */
    ...
}

task deployTest(dependsOn: assembleForTest) << {
    /* execution phase, evaluated only if the task is invoked and after configuration phase for all tasks has been finished */
    ...
}