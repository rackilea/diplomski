{
    "Version":"2012-10-17",
    "Statement":[
        {
            "Sid":"SimulateFolderACL",
            "Effect":"Allow",
            "Principal": "*",
            "Action":["s3:GetObject"],
            "Resource":["arn:aws:s3:::my-bucket/path/to/folder/*"]
        }
    ]
}