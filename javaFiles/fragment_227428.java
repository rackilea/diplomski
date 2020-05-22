{
  "name": "java",
  "description": "Oracle java role",
  "override_attributes": {
    "java": {
      "jdk_version": 8,
      "install_flavor": "oracle",
      "oracle": {
        "accept_oracle_download_terms": true
      }
    }
  },
  "run_list": [
    "recipe[apt]",
    "recipe[java]"
  ]
}