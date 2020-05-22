task test_init(type: Copy, dependsOn: generate_scripts) { 
    from test_script_hsqldb_nd
    from test_script_create_constraints
    from test_script_drop_constraints
    into test_dir
}

// assuming build_classes_dir is not a subdirectory of test_dir, we need a
// second Copy task (every Copy task has a single top-level destination dir)
task test_init_2(type: Copy, dependsOn: generate_scripts) {  
    from test_src_dir
    into build_classes_dir
    include '**/*.xml'
    include '**/*.dtd'
    include '**/*.csv'
    include '**/*.mpp'
    include '**/*.dic'
    include '**/*.png'
    include '**/*.properties'
    includeEmptyDirs = false
}