{
        "Action": ["s3:PutObject",
        "s3:ListBucket",
        "s3:GetObject",
        "s3:DeleteObject"],
        "Resource": ["arn:aws:s3:::yourBucketName",
        "arn:aws:s3:::yourBucketName/*"],
        "Effect": "Allow",
        "Sid": "AllowBucketLinux"
    }